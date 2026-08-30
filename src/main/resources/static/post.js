async function loadPost() {

    const postContainer = document.getElementById("post-container");
    const commentsContainer =
        document.getElementById("comments-container");

    const params = new URLSearchParams(window.location.search);
    const postId = params.get("id");

    if (!postId) {
        postContainer.innerHTML =
            "<p>Post ID is missing.</p>";
        return;
    }

    try {

        // =========================
        // LOAD POST
        // =========================

        const postResponse =
            await fetch(`/api/posts/${postId}`);

        if (!postResponse.ok) {
            throw new Error("Post not found");
        }

        const post = await postResponse.json();

        // Check logged-in user
        const user = JSON.parse(localStorage.getItem("user"));

        let buttons = "";

        // Show Edit/Delete only to the post owner
		if (user && post.user && Number(user.id) === Number(post.user.id)) {
            buttons = `
                <div style="margin-top: 20px;">
                    <button id="edit-post-button">
                        Edit Post
                    </button>

                    <button id="delete-post-button">
                        Delete Post
                    </button>
                </div>

                <p id="post-message"></p>
            `;
        }

        postContainer.innerHTML = `
            <div class="post-card">

                <h2>${post.title}</h2>

                <p>${post.content}</p>

                <div class="post-info">
                    <span>👤 ${post.user.username}</span>
                </div>

                <p>
                    <strong>Created:</strong>
                    ${new Date(post.createdAt).toLocaleString()}
                </p>

                ${buttons}

                <br>

                <a href="index.html">
                    ← Back to Home
                </a>

            </div>
        `;

        // =========================
        // EDIT POST
        // =========================

        const editButton =
            document.getElementById("edit-post-button");

        if (editButton) {

            editButton.addEventListener("click", async () => {

                const newTitle =
                    prompt("Enter new title:", post.title);

                if (newTitle === null) {
                    return;
                }

                const newContent =
                    prompt("Enter new content:", post.content);

                if (newContent === null) {
                    return;
                }

                if (!newTitle.trim() || !newContent.trim()) {
                    alert("Title and content cannot be empty.");
                    return;
                }

                try {

                    const response = await fetch(
                        `/api/posts/${postId}`,
                        {
                            method: "PUT",
                            headers: {
                                "Content-Type": "application/json"
                            },
                            body: JSON.stringify({
                                title: newTitle,
                                content: newContent
                            })
                        }
                    );

                    if (!response.ok) {
                        throw new Error("Unable to update post");
                    }

                    alert("Post updated successfully!");

                    loadPost();

                } catch (error) {

                    console.error(error);

                    alert("Unable to update post.");
                }
            });
        }

        // =========================
        // DELETE POST
        // =========================

        const deleteButton =
            document.getElementById("delete-post-button");

        if (deleteButton) {

            deleteButton.addEventListener("click", async () => {

                const confirmed =
                    confirm(
                        "Are you sure you want to delete this post?"
                    );

                if (!confirmed) {
                    return;
                }

                try {

                    const response = await fetch(
                        `/api/posts/${postId}`,
                        {
                            method: "DELETE"
                        }
                    );

                    if (!response.ok) {
                        throw new Error("Unable to delete post");
                    }

                    alert("Post deleted successfully!");

                    window.location.href = "index.html";

                } catch (error) {

                    console.error(error);

                    alert("Unable to delete post.");
                }
            });
        }

        // =========================
        // LOAD COMMENTS
        // =========================

        const commentsResponse =
            await fetch(`/api/comments/post/${postId}`);

        if (!commentsResponse.ok) {
            throw new Error("Unable to load comments");
        }

        const comments = await commentsResponse.json();

        commentsContainer.innerHTML = "";

        if (comments.length === 0) {

            commentsContainer.innerHTML =
                "<p>No comments yet.</p>";

        } else {

            comments.forEach(comment => {

                const commentCard =
                    document.createElement("div");

                commentCard.className = "comment-card";

                commentCard.innerHTML = `
                    <p>${comment.content}</p>

                    <div class="comment-info">
                        👤 ${comment.user.username}
                        · ${new Date(comment.createdAt)
                            .toLocaleString()}
                    </div>
                `;

                commentsContainer.appendChild(commentCard);
            });
        }

    } catch (error) {

        console.error(error);

        postContainer.innerHTML = `
            <div class="post-card">

                <h2>Unable to Load Post</h2>

                <p>Please try again.</p>

                <a href="index.html">
                    ← Back to Home
                </a>

            </div>
        `;

        commentsContainer.innerHTML =
            "<p>Unable to load comments.</p>";
    }
}


// =========================
// LOAD POST WHEN PAGE OPENS
// =========================

loadPost();


// =========================
// POST COMMENT
// =========================

const commentButton =
    document.getElementById("comment-button");

if (commentButton) {

    commentButton.addEventListener("click", async () => {

        const params =
            new URLSearchParams(window.location.search);

        const postId = params.get("id");

        const content =
            document.getElementById("comment-content")
                .value
                .trim();

        const message =
            document.getElementById("comment-message");

        if (!content) {
            message.textContent =
                "Please write a comment.";
            return;
        }

        try {

            const user =
                JSON.parse(localStorage.getItem("user"));

            if (!user) {

                message.textContent =
                    "Please login before posting a comment.";

                return;
            }

            const response = await fetch(
                `/api/comments?userId=${user.id}&postId=${postId}&content=${encodeURIComponent(content)}`,
                {
                    method: "POST"
                }
            );

            if (!response.ok) {
                throw new Error("Failed to post comment");
            }

            document.getElementById("comment-content").value = "";

            message.textContent =
                "Comment posted successfully!";

            loadPost();

        } catch (error) {

            console.error(error);

            message.textContent =
                "Unable to post comment.";
        }
    });
}