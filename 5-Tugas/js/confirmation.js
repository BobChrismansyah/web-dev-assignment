const inputItem = document.getElementById('input-item');
const btnAddItem = document.getElementById('btn-add-item');
const listContainer = document.querySelector('.list');
const database = new Map();
btnAddItem.addEventListener('click', () => {
  const ITEM_KEY = inputItem.value.toUpperCase();
  const ITEM_VALUE = inputItem.value;

  const listItem = document.createElement('li');
  const textItem = document.createElement('p');
  const btnDelete = document.createElement('button');
  btnDelete.style.color = 'black';
  btnDelete.style.backgroundColor = '#FF6A6A';
  btnDelete.style.border = 'none';
  btnDelete.style.borderRadius = '5px';
  btnDelete.style.marginLeft = '80px';
  btnDelete.style.marginBottom = '1px';
  const counter = document.createElement('button');
  counter.style.color = 'white';
  counter.style.backgroundColor = '#FF6A6A';
  counter.style.border = 'none';
  counter.style.borderRadius = '10px';
  counter.style.marginLeft = '10px';

  if (ITEM_VALUE === '') {
    alert('List tidak boleh kosong');
    inputItem.focus();
    return;
  }

  if (database.has(ITEM_KEY)) {
    alert(`Kamu sudah menambahkan ${ITEM_VALUE}`);
    inputItem.value = '';
    inputItem.focus();
    return;
  }

  database.set(ITEM_KEY, ITEM_VALUE);

  listItem.classList.add('list-item');

  textItem.textContent = ITEM_VALUE;
  btnDelete.textContent = 'Hapus';

  listItem.textContent = ITEM_VALUE;
  listItem.appendChild(btnDelete, counter);
  listContainer.appendChild(listItem);

  btnDelete.addEventListener('click', () => {
    let dialog_konfirmasi = confirm(`Yakin ingin menghapus list ${ITEM_VALUE}?`);
    if (dialog_konfirmasi === false) return;
    listContainer.removeChild(listItem);
    //memberikan informasi ya atau tidak
  });

  inputItem.value = '';
  inputItem.focus();
});
