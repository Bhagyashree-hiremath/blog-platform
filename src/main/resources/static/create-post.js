const form = document.getElementById("create-post-form");

form.addEventListener("submit", async function (event) {

    event.preventDefault();

    const user = JSON.parse(localStorage.getItem("user"));

    const message = document.getElementById("post-message");

    if (!user) {
        message.textContent = "Please login before creating a post.";
        return;
    }

    const title = document.getElementById("title").value.trim();
    const content = document.getElementById("content").value.trim();

    try {

        const response = await fetch("/api/posts", {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                title: title,
                content: content
            })
        });

        if (!response.ok) {
            throw new Error("Failed to create post");
        }

        const post = await response.json();

        console.log("Post created:", post);

        message.textContent = "Post published successfully!";

        form.reset();

        setTimeout(() => {
            window.location.href = "/index.html";
        }, 1000);

    } catch (error) {

        console.error("Create post error:", error);

        message.textContent =
            "Unable to create post.";
    }
});