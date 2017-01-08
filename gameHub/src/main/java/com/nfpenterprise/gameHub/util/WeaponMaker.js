function onInstall(e) {onOpen(e);}

function onOpen(e) {

  SpreadsheetApp.getUi().createMenu('Generate Weapon')
  .addItem("Generate Random Weapon", "rndWeapon")
  .addItem('Generate Sword', 'sword')
  .addItem('Generate Rapier', 'rapier')
  .addItem('Generate Axe', 'axe')
  .addItem('Generate Hammer/Maul', 'hamaul')
  .addItem('Generate Bow', 'bow')
  .addItem('Generate CrossBow', 'crossbow')
  .addItem('Generate Spear', 'spear')
  .addItem('Generate Dagger', 'dagger')
  .addItem('Generate QaurterStaff', 'quarterstaff')
  //.addItem('Discover The Maker', 'maker')
  .addToUi();
  

}

function randomNum(max)
{
    return Math.floor(Math.random()*(max));
}

function display(newWeapon, type, thisMaker, thisFamous) {
  var checkSave = Browser.msgBox("Your New "+type + " 'Yes' to save, 'No' to forget.", newWeapon + "\n\n" + thisMaker + "\n" + thisFamous, Browser.Buttons.YES_NO); 
  
  switch (checkSave) {
    case "yes":
      save(newWeapon, thisMaker, thisFamous, type);
      break;
    default:
      break;      
  }
}

function save(newWeapon, thisMaker, thisFamous, type) {
  var i = 0;
  var out = SpreadsheetApp.getActive().getSheetByName("Display");
  var display = out.getRange("A1:A10000").getValues();
  var next = []
  for (i; i < display.length; i++) {
    if (display[i] == "") {
      next.push(i + 1);
    }
  }
  
  out.getRange("A"+(next[0])).setValue(type + ": " +newWeapon + "\n\n" + thisMaker + "\n" + thisFamous);
}

function rndWeapon() {
  var weaponTypes = ["sword", "rapier", "axe", "hamaul", "bow", "crossbow", "spear", "dagger", "quarterstaff"];
  var rndWeapon = randomNum(weaponTypes.length);
  
  switch (weaponTypes[rndWeapon]) {
    case "sword":
      sword();
      break;
    case "rapier":
      rapier();
      break;
    case "axe":
      axe();
      break;
    case "hamaul":
      hamaul();
      break;
    case "bow":
      bow();
      break;
    case "crossbow":
      crossbow();
      break;
    case "spear":
      spear();
      break;
    case "dagger":
      dagger();
      break;
    case "qaurterstaff":
      quarterstaff();
      break;      
  }                    
}

function genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type) {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");
  
  var maker = ss.getRange("AK2:AK1000").getValues();
  var whoWas = ss.getRange("AL2:AL1000").getValues();
  var famousFor = ss.getRange("AM2:AM1000").getValues();
  
  var totalWQ = [];
  var totalPF = [];
  var totalName1 = [];
  var totalName2 = [];
  var totalMaker = [];
  var totalWhoWas = [];
  var totalFamousFor = [];
  
  for (var i = 0; i < weaponQuality.length; i++) {
    
    if (weaponQuality[i] != "") {
      totalWQ.push(weaponQuality[i]);
    }
    
    if (physicalFeature[i] != "") {
      totalPF.push(physicalFeature[i]);
    }
    
    if (weaponName1[i] != "") {
      totalName1.push(weaponName1[i]);
    }
    
    if (weaponName2[i] != "") {
      totalName2.push(weaponName2[i]);
    }
    
    if (maker[i] != "") {
      totalMaker.push(maker[i]);
    }
    
    if (whoWas[i] != "") {
      totalWhoWas.push(whoWas[i]);
    }
    
    if (famousFor[i] != "") {
      totalFamousFor.push(famousFor[i]);
    }
    
  }
  var rndWQ = randomNum(totalWQ.length);
  var rndPF = randomNum(totalPF.length);
  var rndName1 = randomNum(totalName1.length);
  var rndName2 = randomNum(totalName2.length);
  var rndMaker = randomNum(totalMaker.length);
  var rndWhoWas = randomNum(totalWhoWas.length);
  var rndFamousFor = randomNum(totalFamousFor.length);
  
  var newWeapon = weaponName1[rndName1] + " " + weaponName2[rndName2] + " - " + weaponQuality[rndWQ] + " " + physicalFeature[rndPF];
  var thisMaker = "This weapon was made by a(n) " + maker[rndMaker] + ", who was a " + whoWas[rndWhoWas]; 
  var thisFamous = "This weapon is famous because " + famousFor[rndFamousFor];
  
  display(newWeapon, type, thisMaker, thisFamous);
}

function sword() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");
  
  
  var weaponQuality = ss.getRange("A2:A1000").getValues();
  var physicalFeature = ss.getRange("B2:B1000").getValues();
  var weaponName1 = ss.getRange("C2:C1000").getValues();
  var weaponName2 = ss.getRange("D2:D1000").getValues();
  var type = "Sword";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);  
}

function rapier() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("E2:E1000").getValues();
  var physicalFeature = ss.getRange("F2:F1000").getValues();
  var weaponName1 = ss.getRange("G2:G1000").getValues();
  var weaponName2 = ss.getRange("H2:H1000").getValues();
  var type = "Rapier";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);
}

function axe() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("I2:I1000").getValues();
  var physicalFeature = ss.getRange("J2:J1000").getValues();
  var weaponName1 = ss.getRange("K2:K1000").getValues();
  var weaponName2 = ss.getRange("L2:L1000").getValues();
  var type = "Axe";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);
}

function hamaul() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("M2:M1000").getValues();
  var physicalFeature = ss.getRange("N2:N1000").getValues();
  var weaponName1 = ss.getRange("O2:O1000").getValues();
  var weaponName2 = ss.getRange("P2:P1000").getValues();
  var type = "Hammer or Maul";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);
}

function bow() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("Q2:Q1000").getValues();
  var physicalFeature = ss.getRange("R2:R1000").getValues();
  var weaponName1 = ss.getRange("S2:S1000").getValues();
  var weaponName2 = ss.getRange("T2:T1000").getValues();
  var type = "Bow";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);  
}

function crossbow() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("U2:U1000").getValues();
  var physicalFeature = ss.getRange("V2:V1000").getValues();
  var weaponName1 = ss.getRange("W2:W1000").getValues();
  var weaponName2 = ss.getRange("X2:X1000").getValues();
  var type = "CrossBow";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);  
}

function spear() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("Y2:Y1000").getValues();
  var physicalFeature = ss.getRange("Z2:Z1000").getValues();
  var weaponName1 = ss.getRange("AA2:AA1000").getValues();
  var weaponName2 = ss.getRange("AB2:AB1000").getValues();
  var type = "Spear";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type); 
}

function dagger() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("AC2:AC1000").getValues();
  var physicalFeature = ss.getRange("AD2:AD1000").getValues();
  var weaponName1 = ss.getRange("AE2:AE1000").getValues();
  var weaponName2 = ss.getRange("AF2:AF1000").getValues();
  var type = "Dagger";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);
}

function quarterstaff() {
  var ss = SpreadsheetApp.getActive().getSheetByName("Detail");  
  
  var weaponQuality = ss.getRange("AG2:AG1000").getValues();
  var physicalFeature = ss.getRange("AH2:AH1000").getValues();
  var weaponName1 = ss.getRange("AI2:AI1000").getValues();
  var weaponName2 = ss.getRange("AJ2:AJ1000").getValues();
  var type = "QuarterStaff";
  
  genWeapon(weaponQuality, physicalFeature, weaponName1, weaponName2, type);  
}