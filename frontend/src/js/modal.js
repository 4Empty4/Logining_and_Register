const MODAL_IDS = ["loginModal", "registerModal", "resetPasswordModal"];

export function openModal(id) {
  const modal = document.getElementById(id);
  if (modal) modal.style.display = "flex";
}

export function closeModal(id) {
  const modal = document.getElementById(id);
  if (modal) modal.style.display = "none";
}

export function switchModal(fromId, toId) {
  closeModal(fromId);
  openModal(toId);
}

function setupModals() {
  window.onclick = (event) => {
    MODAL_IDS.forEach(id => {
      if (event.target === document.getElementById(id)) {
        closeModal(id);
      }
    });
  };
}

document.addEventListener('DOMContentLoaded', setupModals);