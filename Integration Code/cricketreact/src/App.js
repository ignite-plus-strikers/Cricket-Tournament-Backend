import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

const PlayerProfiles = () => {
	const [playerProfiles, setPlayerProfiles] = useState([]);
  const fetchPlayerProfiles = () => {
    axios.get("http://localhost:8080/api/players").then(res => {
      console.log(res);
	setPlayerProfiles(res.data);
    });
  };
  useEffect(() => {
    fetchPlayerProfiles();
  }, []);

return playerProfiles.map((playerProfile, index) => {
return (
	<div key={index}>
		
	<center>
            
            <table
              width="1050"
              style={{
                backgroundColor: "white",
                boxShadow: "0px 10px 20px #555",
                borderRadius: "20px",
                marginTop: 20
              }}
            >
              {/* <tr
                style={{
                  backgroundColor: "#B1095D",
                }}
              >
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p className="my-auto">Player Id</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>First Name</p>
                </td>
  
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Last Name</p>
                </td>
  
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Date of Birth</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Gender</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Category</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Nationality</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Player Role</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Batting Style</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Bowling Style</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p>Retired Or Playing</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p className="my-auto">Update</p>
                </td>
                <td
                  style={{
                    borderBottom: "1px solid #ddd",
                    color: "white",
                    padding: "15px",
                    textAlign: "left",
                    fontFamily: "Segoe UI",
                  }}
                >
                  <p className="my-auto">Delete</p>
                </td>
              </tr> */}
              
                  <tr>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>{playerProfile.player_id}</p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>{playerProfile.p_firstname}</p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_lastname}
                          
                      </p>
                    </td>
  
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_dob}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_gender}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_category}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_nationality}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.player_role}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_batting_style}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.p_bowling_style}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                      <p>
                        {playerProfile.retired_or_playing}
                          
                      </p>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >
                    <button style={{flex: 1, flexDirection: 'row', alignItems: 'center', justifyContent: 'center',padding: 10, color: '#ffffff', backgroundColor: '#282c34', borderRadius: 5, border:0}}>Edit
                    </button>
                    </td>
                    <td
                      style={{
                        borderBottom: "1px solid #ddd",
                        color: "#042331",
                        padding: "15px",
                        textAlign: "left",
                        fontFamily: "Segoe UI",
                        fontWeight: 400,
                      }}
                    >                       
                    <button style={{flex: 1, flexDirection: 'row', alignItems: 'center', justifyContent: 'center', padding: 10, color: '#ffffff', backgroundColor: '#282c34', borderRadius: 5, border: 0}}>Delete</button>
                    </td>
                  </tr>

            </table>
</center>
</div>

	)
	})
};

function App() {
  return <div className="App">
      <PlayerProfiles />
    </div>;
}

export default App;
