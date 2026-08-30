document.getElementById("login-form").addEventListener("submit", async function (event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const message = document.getElementById("login-message");

    try {
        const response = await fetch("/api/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        });

        if (!response.ok) {
            throw new Error("Login failed");
        }

        const user = await response.json();

        console.log("Login successful:", user);

        // Save logged-in user
        localStorage.setItem("user", JSON.stringify(user));

        message.textContent = "Login successful!";

        // Go to homepage
        setTimeout(() => {
            window.location.href = "/index.html";
        }, 500);

    } catch (error) {
        console.error("Login error:", error);

        message.textContent =
            "Login failed. Please check your username and password.";
    }
});