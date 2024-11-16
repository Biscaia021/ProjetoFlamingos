const pessoasRadio = document.querySelector("#pessoas");
const contasRadio = document.querySelector("#contas");
const alocacoesRadio = document.querySelector("#alocacoes");
const formPessoas = document.querySelector(".form-pessoas");
const formAlocacoes = document.querySelector(".form-alocacoes");
const formContas = document.querySelector(".form-contas");
const botaoSubmit = document.querySelector(".submit-btn");
const cpf = document.querySelector("#cpf");
const tel = document.querySelector("#telefone");
const selectContas = document.querySelector("#tipo-conta");
const descricao = document.querySelector("#descricao");

cpf.addEventListener('input', function(event) {
  formatarCPF(this);
})

tel.addEventListener('input', function(event) {
  formatarTel(this);
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

pessoasRadio.addEventListener('change', () => {
  formPessoas.classList.remove("hidden");
  formAlocacoes.classList.add("hidden");
  formContas.classList.add("hidden");
});

alocacoesRadio.addEventListener('change', () => {
  formPessoas.classList.add("hidden");
  formAlocacoes.classList.remove("hidden");
  formContas.classList.add("hidden");
})

contasRadio.addEventListener('change', () => {
  formPessoas.classList.add("hidden");
  formAlocacoes.classList.add("hidden");
  formContas.classList.remove("hidden");
})