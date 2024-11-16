let botao_submit = document.querySelector("#botao_submit");
let formulario = document.querySelector("#formulario");

formulario.addEventListener("submit", async (e) => {
  botao_submit.classList.add("carregando");
  let usuario = document.querySelector("#usuario");
  let senha = document.querySelector("#senha");
  e.preventDefault();
  let requisicao = await fetch("https://my-json-server.typicode.com/Alfatist/api_mock/autenticacao");
  let json = await requisicao.json();
  let usuarioAPI = json["login"];
  let senhaAPI = json["senha"];

  let usuarioErro = `<div id="mensagemErro">Usuário Inválido!</div>`;
  let senhaErro = `<div id="mensagemErro">Senha Inválida!</div>`;

  let label_usuario = document.querySelector("#label_usuario");
  let label_senha = document.querySelector("#label_senha");

  label_usuario.classList.remove("erro");
  label_senha.classList.remove("erro");

  if (usuario.value === usuarioAPI && senha.value === senhaAPI) alert("Voce está logado com sucesso");
  else if (usuario.value !== usuarioAPI && senha.value !== senhaAPI) {
    usuario.parentElement.innerHTML += usuarioErro;
    senha.parentElement.innerHTML += senhaErro;

    label_usuario.classList.add("erro");
    label_senha.classList.add("erro");

    label_usuario.addEventListener("click", function validaUsuario() {
      label_usuario.classList.remove("erro");
      label_usuario.querySelector("#mensagemErro").remove();
      label_usuario.removeEventListener("click", validaUsuario);
    });

    label_senha.addEventListener("click", function validaSenha() {
      label_senha.classList.remove("erro");
      label_senha.querySelector("#mensagemErro").remove();
      label_senha.removeEventListener("click", validaSenha);
    });
  } else if (usuario.value !== usuarioAPI) {
    usuario.parentElement.innerHTML += usuarioErro;
    label_usuario.classList.add("erro");

    label_usuario.addEventListener("click", function validaUsuario() {
      label_usuario.classList.remove("erro");
      label_usuario.querySelector("#mensagemErro").remove();
      label_usuario.removeEventListener("click", validaUsuario);
    });
  } else if (senha.value !== senhaAPI) {
    senha.parentElement.innerHTML += senhaErro;
    label_senha.classList.add("erro");

    label_senha.addEventListener("click", function validaSenha() {
      label_senha.classList.remove("erro");
      label_senha.querySelector("#mensagemErro").remove();
      label_senha.removeEventListener("click", validaSenha);
    });
  }
  botao_submit.classList.remove("carregando");
  // formulario.lastChild.remove();
});
