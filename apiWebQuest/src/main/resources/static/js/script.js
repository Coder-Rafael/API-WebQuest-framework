// Dados mockados de usuários
var mockUsuarios = [
    { username: "rafael3590", password: "3590" },
    { username: "usuario2", password: "abc456" },
    { username: "usuario3", password: "123abc" }
];

// Função para verificar as credenciais do usuário
function verificarCredenciais(username, password) {
    for (var i = 0; i < mockUsuarios.length; i++) {
        if (mockUsuarios[i].username === username && mockUsuarios[i].password === password) {
            //redireciona para a página principal
            window.location.href = '../html/main.html';
            return true;
        }
    }
    console.log("nao funf"); // Mostra no console quando as credenciais estão incorretas
    return false; // Credenciais não correspondem a nenhum usuário
}

// Função de evento para processar o login
function fazerLogin() {
    var usernameInput = document.getElementById("username").value;
    var passwordInput = document.getElementById("password").value;

    if (verificarCredenciais(usernameInput, passwordInput)) {
        alert("Login bem-sucedido! Redirecionando para a página principal..."); // Você pode redirecionar o usuário para a página principal aqui
    } else {
        alert("Credenciais inválidas. Por favor, tente novamente."); // Exibir uma mensagem de erro
    }
}

// Adicione um ouvinte de evento ao botão de login
var login = document.getElementById("login");
login.addEventListener("click", fazerLogin);