<!--
Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE

Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
-->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
  <r:require modules="flashPlayer"/>
  <r:layoutResources/>
</head>
<body>
  <div id="test">
    <p>You need <a href="http://www.adobe.com/go/getflashplayer">Flash Player</a>
      installed and JavaScript enabled to play this media.</p>
  </div>
<g:flashPlayer id="test" varFile="${createLinkTo(dir: 'mediaplayer-5.8', file: 'video.mp4')}"/>

<div id="mediaplayer">
  <p>You need <a href="http://www.adobe.com/go/getflashplayer">Flash Player</a>
    installed and JavaScript enabled to play this media.</p>
</div>

<script type="text/javascript">
        jwplayer("mediaplayer").setup({
                flashplayer: "${createLinkTo(dir: 'mediaplayer-5.8', file: 'player.swf')}",
                file: "${createLinkTo(dir: 'mediaplayer-5.8', file: 'video.mp4')}",
                image: "${createLinkTo(dir: 'mediaplayer-5.8', file: 'preview.jpg')}"
        });
</script>

</body>
</html>
