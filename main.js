const { app, BrowserWindow, ipcMain } = require("electron");

require("@babel/register");

let win



app.on("window-all-closed", () => {
  if (process.platform !== "darwin") app.quit()
})

app.on("ready", () => {


  win = new BrowserWindow({
    width: 800,
    height: 600,
    minWidth: 400,
    minHeight: 300,
    frame: false,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false
    },
    icon: "src/img/icon.ico"
  });



  
  ipcMain.on("close-app", () => {win.close()});
  ipcMain.on("minimize-app", () => {win.minimize()});
  ipcMain.on("maximize-app", () => {
    if (win.isMaximized()) {
      win.restore()
    } else {
      win.maximize()
    }
  });


  win.loadFile("index.html");
})



