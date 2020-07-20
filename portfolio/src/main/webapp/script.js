
function addRandomGreeting() {
  const greetings =
      ['hello', '你好','hi','你好呀'];

  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

function getComments() {
  const languagesDropdown = document.getElementById("languages");
  const language = languagesDropdown.options[languagesDropdown.selectedIndex].value;

  fetch('/comments?lang='+language).then(response => response.json()).then((comments) => {
    const commentsContainer = document.getElementById('comments-container');
    commentsContainer.innerHTML = "";
    for (let i = 0; i< comments.length; i++){
        let comm = document.createElement("P");
        comm.innerHTML = comments[i];
        comm.classList.add("comment");
        commentsContainer.appendChild(comm);
    }
  });
}

function loadPage(){
    getComments();
}
