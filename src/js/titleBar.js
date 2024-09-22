const { ipcRenderer } = require("electron")

const minimize = document.getElementById("minimize")
const maximize = document.getElementById("maximize")
const close = document.getElementById("close")

minimize.addEventListener("click", () => {
  ipcRenderer.send("minimize-app");
});

maximize.addEventListener("click", () => {
  ipcRenderer.send("maximize-app");
});

close.addEventListener("click", async () => {
  ipcRenderer.send("close-app");
});

