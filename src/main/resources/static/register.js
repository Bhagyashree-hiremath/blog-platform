document.getElementById("register-form").addEventListener("submit", async function (event) {

    event.preventDefault();

    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const message = document.getElementById("register-message");

    try {

        const response = await fetch("/api/auth/register", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                username: username,
                email: email,
                password: password
            })
        });

        if (!response.ok) {
            throw new Error("Registration failed");
        }

        const user = await response.json();

        console.log("Registration successful:", user);

        message.textContent = "Registration successful!";

        setTimeout(() => {
            window.location.href = "/login.html";
        }, 1000);

    } catch (error) {

        console.error("Registration error:", error);

        message.textContent =
            "Registration failed. Please try again.";
    }
});