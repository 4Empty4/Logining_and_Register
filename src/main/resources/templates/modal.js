
function openModal(id) {
  document.getElementById(id).style.display = "flex";
}


function closeModal(id) {
  document.getElementById(id).style.display = "none";
}



function switchModal(fromId, toId) {
  closeModal(fromId);
  openModal(toId);

}


window.onclick = function (event) {
  const loginModal = document.getElementById("loginModal");
  const registerModal = document.getElementById("registerModal");
  const resetPasswordModal = document.getElementById("resetPasswordModal");

  if (event.target === loginModal) {
    closeModal("loginModal");
  }

  if (event.target === registerModal) {
    closeModal("registerModal");
  }
    if (event.target === resetPasswordModal) {
        closeModal("resetPasswordModal");
    }
};
