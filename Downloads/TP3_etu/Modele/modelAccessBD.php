<?php
class modelAccessBD{
    private $PDOInstance = null;
    private static $instance = null;
    private function __construct()
    {
        try{
            $this->PDOInstance=new PDO('mysql:host=localhost;dbname=tp3a18', 'root', 'root');

        }catch (Exception $e){
            $_SESSION['Page'] = 'Erreur';
            $_SESSION['Erreur'] = 'Erreur de connexion';
        }
    }
    public static function getInstance(){
        if(is_null(self::$instance)){
            self::$instance = new modelAccessBD();
        }
        return self::$instance;
    }
    public function insertUser($ID, $NOM, $MOTPASSE){
        $sql = "insert into `tp3a18`.UTILISATEUR values('$ID','$NOM','$MOTPASSE')";
        self::sendSql($sql);
    }
    public function selectUser($NOM)
    {
        $sql = "select NOM from `tp3a18`.UTILISATEUR where NOM='$NOM'";
        return self::sendSql($sql);
    }

    public function validateUserPass($NOM, $MOTPASSE)
    {
        $sql = "SELECT NOM FROM `tp3a18`.UTILISATEUR WHERE NOM = '$NOM' AND MOTPASSE ='$MOTPASSE'";
        return self::sendSql($sql);
    }


    public function sendSql($sql)
    {

        try
        {
            $query = $this->PDOInstance->prepare($sql);
            $query->execute();
            $tab = $query->fetchAll(PDO::FETCH_ASSOC);
        } catch (Exception $e)
        {
            $tab = false;
        }
        return $tab;
    }

}
?>

