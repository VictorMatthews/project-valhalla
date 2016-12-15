package com.nfpenterprise.gameHub.constants;

public enum Paths {
	ROOT_LAYOUT_FXML("view/RootLayout.fxml");
	
	private final String path;
	
	Paths(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}
