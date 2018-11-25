<?php
require 'Modele/modelAccessBD.php';

function accueil()
{
    require 'Vue/vueAccueil.php';
}


function erreur($msgErreur)
{
    require 'Vue/vueErreur.php';
}
function journal(){
    require 'Vue/vueJournal.php';
}

