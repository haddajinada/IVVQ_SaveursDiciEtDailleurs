/*******************************************************************************
 * Saveurs d’ici et d’ailleurs allows foodies to share recipes and cooking tips from around the globe.
 * Copyright (C) 2012 Anna CEJALVO - Nada HADDAJI KFITA - Ahou Melaine KOFFI - Marième TOURE
 * 
 * Saveurs d’ici et d’ailleurs is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Saveurs d’ici et d’ailleurs is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see ww.gnu.org/licenses/agpl-3.0.html.
 ******************************************************************************/
package ivvq_saveursdicietdailleurs

class YouTubeVideoTagLib {
   
    def video={attrs->
        def videoKey = attrs['videoKey']
        def vd = {
            object(width: attrs['width'] ?: "640", height:attrs['height'] ?: "385") {
                param(
                    name: "movie",
                    value: "http://www.youtube-nocookie.com/v/${videoKey}?fs=1&amp;amp;hl=en_US")
                param(name: "allowFullScreen", value:"true")
                param(name: "allowscriptaccess", value:"always")
                embed(src: "http://www.youtube-nocookie.com/v/${videoKey}?fs=1&amp;amp;hl=en_US",
                    type: "application/x-shockwave-flash",allowscriptaccess:"always",allowfullscreen:"true",
                    width: "${attrs['width']?:'640'}", height:"${attrs['height']?:'385'}")
           }
         }
        
         def xml = new groovy.xml.StreamingMarkupBuilder().bind(vd)
         out << xml
    }
}

