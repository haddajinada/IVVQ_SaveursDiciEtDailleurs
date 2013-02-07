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
