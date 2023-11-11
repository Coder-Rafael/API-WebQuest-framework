
    document.querySelectorAll('.scroll-section').forEach(section => {
        section.addEventListener('click', () => {
            window.scrollTo({
                top: section.offsetTop,
                behavior: 'smooth'
            });
        });
    });

// Adicione um ouvinte de evento ao botão de login
var backToLoginButton = document.getElementById("button_login");
backToLoginButton.addEventListener("click", voltarParaTelaDeLogin);

function voltarParaTelaDeLogin() {
    // Redirecione o usuário de volta à tela de login
    window.location.href = '/webQuest/index.html';
}

const questionario = document.querySelector(".questionario");
document.getElementById("button_avaliacao").onclick = habilitaQuestionario;

function habilitaQuestionario(){
  questionario.style.display = "flex";
}

document.getElementById("finish").onclick = fecharQuestionario;
function fecharQuestionario(){
  console.log("chegou na funçaõ");
  questionario.style.display = "none";
}

// --------------------------------------

  const questionContainer = document.getElementById  ("question-container");
  const resultContainer = document.getElementById("result-container");
  const questionElement = document.getElementById("question");
  const answersElement = document.getElementById("answers");
  const resultElement = document.getElementById("result");
  const btnFinish = document.getElementById("finish");
  const btnInit = document.getElementById("button_avaliacao");

        let currentQuestionIndex = 0;
        let correctAnswers = 0;

        function displayQuestion() {
            const currentQuestion = questions[currentQuestionIndex];
            questionElement.textContent = currentQuestion.question;

            answersElement.innerHTML = "";

            currentQuestion.answers.forEach((answer, index) => {
                const answerButton = document.createElement("button");
                answerButton.textContent = answer.option;
                answerButton.setAttribute("id", "btnAlt");
                answerButton.addEventListener("click", () => checkAnswer(index));
                answersElement.appendChild(answerButton);
            });
        }

        function checkAnswer(selectedIndex) {
            const currentQuestion = questions[currentQuestionIndex];
            if (currentQuestion.answers[selectedIndex].correct) {
                correctAnswers++;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                displayResult();
            }
        }

        function displayResult() {
            questionContainer.style.display = "none";
            resultContainer.style.display = "flex";
            resultElement.textContent = `Você acertou ${correctAnswers} de ${questions.length} questões.`;
            btnInit.style.display = "none";
        }

        document.getElementById("init").onclick = iniciarQuestionario;

        function iniciarQuestionario() {
            questionContainer.style.display = "flex";
            document.querySelector(".ready-div").style.display = "none";
            displayQuestion();
        }

        const questions = [
          {
            question: "O que é um framework de desenvolvimento??",
            answers: [
              { option: "Um software usado apenas para design gráfico.", correct: false },
              { option: "Uma estrutura que fornece um conjunto de funcionalidades pré-construídas para facilitar o desenvolvimento de software.", correct: true },
              { option: "Um aplicativo de gerenciamento de projetos.", correct: false },
            ],
          },
          {
            question: "Qual é a principal finalidade de um framework front-end?",
            answers: [
              { option: "Gerenciar o servidor e o banco de dados.", correct: false },
              { option: "Fornecer uma estrutura para criar a interface do usuário de um aplicativo web.", correct: true },
              { option: "Realizar análise de dados.", correct: false },
            ],
          },
          {
            question: "Quais são algumas das vantagens do uso de frameworks no desenvolvimento de software?",
            answers: [
              { option: "Aumento da complexidade do código e dificuldade de manutenção.", correct: false },
              { option: "Economia de tempo, reutilização de código e padrões estabelecidos.", correct: true },
              { option: "Diminuição do desempenho do aplicativo.", correct: false },
            ],
          },
          {
            question: "Qual dos seguintes é um exemplo de framework front-end popular?",
            answers: [
              { option: "Django.", correct: false },
              { option: "React", correct: false },
              { option: "Express.js", correct: true },
            ],
          },
          {
            question: "O que faz um framework back-end?",
            answers: [
              { option: "Cria a interface do usuário de um aplicativo..", correct: false },
              { option: "Gerencia o servidor e o banco de dados", correct: true },
              { option: "Realiza análise de dados.", correct: false },
            ],
          },
        ];

