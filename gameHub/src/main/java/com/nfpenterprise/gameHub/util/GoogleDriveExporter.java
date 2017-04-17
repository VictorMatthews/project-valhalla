package com.nfpenterprise.gameHub.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.nfpenterprise.gameHub.constants.Paths;

public class GoogleDriveExporter {
	private static LocalServerReceiver localServerReceiver = null;
	private static final String ISO_CHARACTER_ENCODING = "ISO-8859-15";
	private static final String APPLICATION_NAME = "Google Drive Exporter";
	private static final String DEFAULT_FOLDER_NAME = "Project Valhalla Character XMLs";
	private static final int HTTP_TIMEOUT_IN_SECONDS = 150;
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty(Paths.USER_HOME_DIR.getPath()), Paths.OAUTH_TOKEN.getPath());
	private static FileDataStoreFactory DATA_STORE_FACTORY;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static HttpTransport HTTP_TRANSPORT;
	/**
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/drive-java-quickstart.json
	 */
	private static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE_FILE);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private static Credential authorize() throws IOException {

		// Load client secrets.
		InputStream in = GoogleDriveExporter.class.getResourceAsStream(Paths.CLIENT_SECRET.getPath());
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in, ISO_CHARACTER_ENCODING));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();

		AuthorizationCodeInstalledApp app = new AuthorizationCodeInstalledApp(flow,
				setLocalServerReceiver(new LocalServerReceiver()));
		Credential credential = app.authorize("user");

		return credential;
	}

	private static LocalServerReceiver setLocalServerReceiver(LocalServerReceiver localServerReceiver)
			throws IOException {
		if (GoogleDriveExporter.localServerReceiver == null) {
			GoogleDriveExporter.localServerReceiver = localServerReceiver;
		} else {
			GoogleDriveExporter.localServerReceiver.stop();
			GoogleDriveExporter.localServerReceiver = localServerReceiver;
		}
		return GoogleDriveExporter.localServerReceiver;
	}

	public static Drive getDriveService() throws IOException {
		final Credential credential = authorize();

		return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setHttpRequestInitializer(new HttpRequestInitializer() {
					@Override
					public void initialize(HttpRequest httpRequest) throws IOException {
						credential.initialize(httpRequest);
						httpRequest.setConnectTimeout(HTTP_TIMEOUT_IN_SECONDS * 10000);
						httpRequest.setReadTimeout(HTTP_TIMEOUT_IN_SECONDS * 10000);

					}
				}).setApplicationName(APPLICATION_NAME).build();
	}

	public static String exportXmlFileToGoogleDrive(Drive driveService, java.io.File file) throws IOException {
		String folderId = findOrCreateFolderIdForExport(driveService);

		File fileMetadata = new File();
		fileMetadata.setName("ProjectValhallaCharacters");
		fileMetadata.setParents(Collections.singletonList(folderId));
		fileMetadata.setMimeType("application/vnd.xml");

		FileContent mediaContent = new FileContent("application/vnd.xml", file);

		File sheetsFile = driveService.files().create(fileMetadata, mediaContent).setFields("webViewLink").execute();
		return sheetsFile.getWebViewLink();
	}

	private static String findOrCreateFolderIdForExport(Drive service) throws IOException {
		String folderId = null;
		String pageToken = null;
		do {
			FileList result = service.files().list().setQ("mimeType='application/vnd.google-apps.folder'")
					.setSpaces("drive").setFields("nextPageToken, files(id, name, trashed)").setPageToken(pageToken)
					.execute();
			for (File file : result.getFiles()) {
				if (file.getName().equals(DEFAULT_FOLDER_NAME) && BooleanUtils.isFalse(file.getTrashed())) {
					folderId = file.getId();
					break;
				}
			}
			pageToken = result.getNextPageToken();
		} while (pageToken != null);

		if (folderId == null) {
			File folderMetaData = new File();
			folderMetaData.setName(DEFAULT_FOLDER_NAME);
			folderMetaData.setMimeType("application/vnd.google-apps.folder");

			File folder = service.files().create(folderMetaData).setFields("id").execute();

			folderId = folder.getId();
		}
		return folderId;
	}

}