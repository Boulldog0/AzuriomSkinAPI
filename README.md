# AzuriomSkinAPI
**Plugin minecraft permettant d'auto-update son skin via l'api SkinAPI de Azuriom**

# Le plugin utilise le sous plugin SkinRestorer afin d'appliquer un skin venant de l'api SkinApi de votre site a un utilisateur quand il se connecte ou, si il le change sur le site en étant connecté, pouvoir l'update via une commande.

**Commandes, Description et permission :**

| Commande | Description | Permission |
|----------|----------|----------|
| /skin-update  | Permet d'update son propre skin en étant connecté.  | azuriomskinapi.skin-update | 
| /azuriomskinapi-reload | Permet de reload le plugin | azuriomskinapi.reload | 
| /forceupdate-skin | Permet de forcer l'update d'un skin sur un utilisateur connecté. | azuriomskinapi.forceupdate |


## Vous pouvez changer l'intégralité des messages du plugin via le fichier de configuration.

**Présentation du fichier de configuration :**

![Configuration de base](https://cdn.discordapp.com/attachments/1109918463415291944/1152636464128073850/image.png)

Présentation dans les grands traits : 

1. skin_api_url : Mettre le premier lien présenté dans la configuration du plugin Azuriom ( plugin SkinAPI ), en changeant {playerid} par {player}
2. delay_tick : Delai en ticks avant l'actualisation du skin lors de la connexion d'un joueur ( 20 ticks = 1 seconde )

**Tout les autres messages sont des messages affichés selon le contexte des commandes.**

**Edit : Cela ne fonctionne pas si vous avez le plugin SkinRestorer en version Bungeecord.**

Serveur discord de support : https://discord.gg/2cVcYB2GaZ
Post SpigotMC : https://www.spigotmc.org/resources/azuriomskinapi.112676/
