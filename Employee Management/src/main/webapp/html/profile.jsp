<!DOCTYPE html>
<html lang="en">

<head>
  
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  
  <title>Employee Details</title>

<style>

    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #ffe6d4, #f7c7a3);
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .details-card {
        background: #ffffff;
        width: 420px;
        max-width: 90%;
        padding: 25px;
        border-radius: 16px;
        box-shadow: 
            0 8px 18px rgba(0,0,0,0.1),
            0 10px 25px rgba(0,0,0,0.1);
        animation: fadeIn 0.5s ease;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(20px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h2 {
        text-align: center;
        margin-bottom: 30px;
        font-size: 26px;
        color: #333;
    }

    .row {
        margin-bottom: 20px;
    }

    .label {
        font-weight: bold;
        color: #555;
        display: block;
        margin-bottom: 6px;
        font-size: 14px;
    }

    .value {
        background: #f5f5f5;
        padding: 12px 14px;
        border-radius: 8px;
        border: 1px solid #ddd;
        font-size: 15px;
        color: #333;
        user-select: none;
        position: relative;
    }

    /* grid for 2 columns */
    .grid {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 18px;
    }

    /* password eye */
    .password-wrapper {
        position: relative;
    }

    .eye-icon {
        width: 22px;
        position: absolute;
        right: 12px;
        top: 50%;
        transform: translateY(-50%);
        cursor: pointer;
        opacity: 0.7;
        transition: 0.2s;
    }

    .eye-icon:hover {
        opacity: 1;
    }

    /* logout button */
    .logout-wrap {
        text-align: center;
        margin-top: 25px;
    }

    .logout-btn {
        padding: 10px 25px;
        background: #ff4a4a;
        color: white;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        font-size: 16px;
        transition: 0.2s;
    }

    .logout-btn:hover {
        background: #d93a3a;
    }

</style>

</head>
<body>

  <div class="details-card">

    <h2>Employee Profile</h2>

    <div class="row">
      <span class="label">Employee ID</span>
      <div class="value"><%= request.getAttribute("employee_id") %></div>
    </div>

    <div class="grid">
      <div class="row">
        <span class="label">First Name</span>
        <div class="value"><%= request.getAttribute("first_name") %></div>
      </div>

      <div class="row">
        <span class="label">Last Name</span>
        <div class="value"><%= request.getAttribute("last_name") %></div>
      </div>
    </div>

    <div class="row">
      <span class="label">Mobile Number</span>
      <div class="value"><%= request.getAttribute("mobileNumber") %></div>
    </div>

    <div class="row">
      <span class="label">Email</span>
      <div class="value"><%= request.getAttribute("email") %></div>
    </div>

    <!-- password box with eye icon -->
    <div class="row">
      <span class="label">Password</span>
      <div class="value password-wrapper" id="passBox">
        <span id="passText">**********</span>

        <img class="eye-icon" id="toggleEye" 
            src="data:image/svg+xml;utf8,
            <svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' 
            fill='none' stroke='%23888' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'>
              <path d='M1 12s4-7 11-7 11 7 11 7-4 7-11 7S1 12 1 12z'/>
              <circle cx='12' cy='12' r='3'/>
            </svg>"
        />
      </div>
    </div>

    <div class="row">
      <span class="label">Gender</span>
      <div class="value"><%= request.getAttribute("gender") %></div>
    </div>

    <div class="logout-wrap">
        <a href="Logout"><button class="logout-btn">Logout</button></a>
    </div>

  </div>

<script>
  
  let isShown = false;
  
  const eye = document.getElementById("toggleEye");
  
  const passText = document.getElementById("passText");
  
  const realPass = '<%= request.getAttribute("password") %>';

  eye.onclick = () => {
    if (!isShown) {
      passText.innerText = realPass;
      isShown = true;
      eye.src = "data:image/svg+xml;utf8,<svg ...eye-open-icon...></svg>";
    } 
    else {
      passText.innerText = "************";
      isShown = false;
      eye.src = "data:image/svg+xml;utf8,<svg ...eye-closed-icon...></svg>";
    }
  };

</script>


</body>
</html>
