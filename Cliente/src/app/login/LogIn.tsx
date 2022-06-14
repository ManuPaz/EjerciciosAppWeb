import './Login.css';
import React, { useState} from "react";
import { useSelector, useDispatch } from 'react-redux';
import { login } from "../services/juegos";
import { loguear} from "../../app/redux/tokenSlice";
export function setCookie(name:string,value:string,days:any) {
  var expires = "";
  if (days) {
      var date = new Date();
      date.setTime(date.getTime() + (days*24*60*60*1000));
      expires = "; expires=" + date.toUTCString();
  }
  document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
export  function Login() {
        const dispatch = useDispatch();
        
        const [password, setPassword] = useState("");
        const [userName, setUser] = useState("");
        function handleUserChange(event: any) {
            setUser(event.target.value);
          }
          function handlePasswordChange(event: any) {
            setPassword(event.target.value);
          }
      function log() {
        login(userName,password).then((response) => {
          if(response.status==200){
            dispatch(loguear(userName));
            setCookie("user", userName,30); //set "user_email" cookie, expires in 30 days
          }
         
         
        })
        .catch((error) => {
          console.log(error);
          alert("Log in incorrecto");
          
        })
       
      }
  return(
    <div className="login-wrapper">
      <h1>Por favor incia sesión:</h1>
     
        <label>
          <p>User name</p>
          <input type="text"     value={userName} onChange={handleUserChange} />
        </label>
        <label>
          <p>Password</p>
          <input type="password" value={password}  onChange={handlePasswordChange} />
        </label>
        <div>
          <button onClick={log}>Log in</button>
        </div>
     
    </div>
  )
}