<?php
require 'Controleur/Controleur.php';

try {
    if(isset($_POST['sub_btn_deconnexion'])){
        unset($_SESSION['currentuser']);
    }

    accueil();
} catch (Exception $e) {
    erreur($e->getMessage());
}