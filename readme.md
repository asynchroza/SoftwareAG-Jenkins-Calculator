<h2>Calculator on CI Jenkins pipeline</h2>
<hr/>
<p> Bash script to run the program with input from the command-line and then run the tests * </p>
<a href="https://ibb.co/kDhwtPr"><img src="https://i.ibb.co/3F0jnP8/image.png" alt="image" border="0"></a>
<hr/>
<p> Bash script reading variables from text_input.txt and passing them as input to the program ** used during CI </p>
<a href="https://imgur.com/a/rXIn1e4"> The image uploading service I usually use was down for maintenance </a>
<p> * Should be run in root directory </p>
<p> ** Essentially, they are the same script but one is sourcing the input from a text file and the other one is getting them as passed arguments </p>
<li> <strong>NB!<strong> If you pass * as an argument you should pass it with quotes, because the asterics is kind of a wildcard in bash </li>
<hr/>
  <h3>Test coverage:</h3>
  <a href="https://imgbb.com/"><img src="https://i.ibb.co/xq2SB2J/image.png" alt="image" border="0"></a>
<hr/>
  <h3>Jenkins CI </h3>
  <a href="https://ibb.co/ZGw59RL"><img src="https://i.ibb.co/Ntk5RgV/image.png" alt="image" border="0"></a>
  <li>Scheduled as <em>0 8 * * *</em></li>
  <br/>
  <hr/>
  <h3>CircleCI</h3>
  <a href="https://ibb.co/q96mcbG"><img src="https://i.ibb.co/S0SVMqT/image.png" alt="image" border="0"></a>
<hr/>
  <h3>Tech stack: </h3>
  <ul>
    <li>Maven 3.6.3 and JDK 11 for better compitability</li>
    <li>JUNIT 5.8.2 for testing</li>
  </ul>
