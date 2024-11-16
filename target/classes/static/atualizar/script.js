const pessoasRadio = document.querySelector("#pessoas");
const alocacoesRadio = document.querySelector("#alocacoes");
const formPessoas = document.querySelector(".form-pessoas");
const formAlocacoes = document.querySelector(".form-alocacoes");
const formAtualizarPessoas = document.querySelector(".form-atualizarPessoas");
const formAtualizarAlocacoes = document.querySelector(".form-atualizarAlocacoes");

pessoasRadio.addEventListener('change', () => {
  formPessoas.classList.remove("hidden");
  formAlocacoes.classList.add("hidden");
  formAtualizarAlocacoes.classList.add("hidden");
});

alocacoesRadio.addEventListener('change', () => {
  formPessoas.classList.add("hidden");
  formAlocacoes.classList.remove("hidden");
  formAtualizarPessoas.classList.add("hidden");
})

formPessoas.addEventListener('submit', atualizarDados);
formAlocacoes.addEventListener('submit', atualizarDados)

function atualizarDados(event) {
  if(pessoasRadio.checked){
    formPessoas.classList.add("hidden");
    formAtualizarPessoas.classList.remove("hidden");
    event.preventDefault();
  }
  if(alocacoesRadio.checked){
    formAlocacoes.classList.add("hidden");
    formAtualizarAlocacoes.classList.remove("hidden");
    event.preventDefault();
  }
}

const inputIdPessoa = document.querySelector("#idPessoa");

const cpf = document.querySelector("#cpf");

cpf.addEventListener('input', function(event) {
  formatarCPF(this);
})

function formatarCPF(input) {
  let cpf = input.value.replace(/\D/g, '');
  if(cpf.length > 3) {
    cpf = cpf.substring(0, 3) + '.' + cpf.substring(3);
  } 
  if(cpf.length > 7) {
    cpf = cpf.substring(0, 7) + '.' + cpf.substring(7);
  }
  if(cpf.length > 11) {
    cpf = cpf.substring(0, 11) + '-' + cpf.substring(11);
  }
  input.value = cpf;
}

const tel = document.querySelector("#telefone");

tel.addEventListener('input', function(event) {
  formatarTel(this);
})

function formatarTel(input) {
  let tel = input.value.replace(/\D/g, '');
  if(tel.length > 2){
    tel = '(' + tel.substring(0, 2) + ')' + tel.substring(2);
  }
  if(tel.length > 7){
    tel = tel.substring(0, 9) + '-' + tel.substring(9);
  }
  input.value = tel;
}