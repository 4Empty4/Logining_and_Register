function openModal() {
  document.getElementById("loginModal").style.display = "flex";
}

function closeModal() {
  document.getElementById("loginModal").style.display = "none";
}

window.onclick = function (event) {
  const modal = document.getElementById("loginModal");

  if (event.target === modal) {
    closeModal();
  }
};
