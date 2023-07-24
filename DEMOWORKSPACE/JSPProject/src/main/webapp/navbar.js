document.addEventListener('DOMContentLoaded', function() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'navbar.html', true);
    xhr.onreadystatechange = function() {
      if (this.readyState === 4 && this.status === 200) {
        var navbar = document.createElement('div');
        navbar.innerHTML = this.responseText;
        document.body.insertBefore(navbar, document.body.firstChild);
      }
    };
    xhr.send();
  });
  