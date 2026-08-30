function showMessage() {
    alert("Welcome to the Blog Platform!");
}

async function loadPosts() {

    const postsContainer = document.getElementById("posts-container");

    try {

        const response = await fetch("/api/posts");

        if (!response.ok) {
            throw new Error("Failed to load posts");
        }

        const posts = await response.json();

        postsContainer.innerHTML = "";

        if (posts.length === 0) {
            postsContainer.innerHTML = "<p>No posts available.</p>";
            return;
        }

        posts.forEach(post => {

            const postCard = document.createElement("div");

            postCard.className = "post-card";

            postCard.innerHTML = `
                <h3>${post.title}</h3>

                <p>${post.content}</p>

                <div class="post-info">
                    <span>👤 ${post.user.username}</span>
                    <span>💬 Comments</span>
                </div>

                <button onclick="viewPost(${post.id})">
                    Read More
                </button>
            `;

            postsContainer.appendChild(postCard);
        });

    } catch (error) {

        console.error("Error loading posts:", error);

        postsContainer.innerHTML =
            "<p>Unable to load posts. Please make sure the server is running.</p>";
    }
}
function viewPost(postId) {
    window.location.href = `post.html?id=${postId}`;
}


loadPosts();
function updateNavigation() {

    const user = JSON.parse(localStorage.getItem("user"));

    const userInfo = document.getElementById("user-info");
    const loginLink = document.getElementById("login-link");
    const registerLink = document.getElementById("register-link");
    const logoutLink = document.getElementById("logout-link");

    if (user) {

        userInfo.textContent = `Welcome, ${user.username}!`;

        loginLink.style.display = "none";
        registerLink.style.display = "none";
        logoutLink.style.display = "inline";

    } else {

        userInfo.textContent = "";

        loginLink.style.display = "inline";
        registerLink.style.display = "inline";
        logoutLink.style.display = "none";
    }
}


document.getElementById("logout-link").addEventListener("click", function(event) {

    event.preventDefault();

    localStorage.removeItem("user");

    window.location.href = "index.html";
});


updateNavigation();