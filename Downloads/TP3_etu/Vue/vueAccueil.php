<?php// Auteur : 2017-10-01 Anne-Claire Tassel - David Bellemare?>
<?php// Modifie : 2018-11-16 Dominique?>

<body>
	<form action="/TP3_etu/index.php" method="post">
		<table>
			<tr>
				<td><label for="identifiant">Identifiant :</label></td>
				<td><input type="text" name="nom" id="nom" value="" required />
				</td>
			</tr>
			<tr>
				<td><label for="mdp">Mot de passe :</label></td>
				<td><input type="password" name="mdp" id="mdp" value="" required />
				</td>
			</tr>
		</table>
		<br /> <input type="submit" name="sub_nv" value="Nouvel utilisateur" />
		<input type="submit" name="sub_connexion" value="Connexion" />
	</form>

</body>


