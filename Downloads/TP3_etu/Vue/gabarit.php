<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="Contenu/style.css" />
        <title><?=$titre ?></title>
    </head>
    <body>
        <div id="global">
            <header>
                <h1 id="titreBlog"><?=$titre ?></h1>
                <p>Je vous souhaite la bienvenue sur ce modeste blog.</p>
            </header>
            <div id="contenu">
                <?= $contenu ?>
            </div> <!-- #contenu -->
            <footer id="piedBlog">
                TP3 420-306-LI 2018
            </footer>
        </div> <!-- #global -->
    </body>
</html>


?>
