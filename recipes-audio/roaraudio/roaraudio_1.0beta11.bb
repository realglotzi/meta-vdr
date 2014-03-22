DESCRIPTION = "RoarAudio"
SECTION = "gpe/base"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=372b8da04330eb1ca41226c4d603abee"
DEPENDS = "alsa-lib"

inherit update-rc.d

INITSCRIPT_NAME = "roaraudio"
INITSCRIPT_PARAMS = "defaults 20" 
 
PR = "r2"

SRC_URI = "http://roaraudio.keep-cool.org/dl/roaraudio-1.0beta11.tar.gz \
           file://init"

SRC_URI[md5sum] = "4e5d4d20566983b2565f2a4ce2c5842e"
SRC_URI[sha256sum] = "13db2dfc97e48c10cc8caf96a1d9e8733ea3bc49a08d314f607bd4a64870c379"

                                                                                                                                                                                              
FILES_${PN} = "${bindir}/roar* \                                                                                                                                                              
               ${libdir}/lib* \                                                                                                                                                               
               ${libdir}/roaraudio/plugins/* \                                                                                                                                                
               ${libdir}/roaraudio/compbins/* \                                                                                                                                               
               ${libdir}/roaraudio/complibs/lib*"                                                                                                                                             
                                                                   
FILES_${PN}-dbg += " ${libdir}/lib* \
                     ${libdir}/roaraudio/* \
                     ${libdir}/roaraudio/build-system/* \
                     ${libdir}/ckport/* \
                     ${libdir}/roaraudio/plugins/0-RoarAudio/roard/0-RoarAudio/.debug \
                     ${libdir}/roaraudio/plugins/universal/universal/0-RoarAudio/.debug"                                                                                                    
do_configure() {
	./configure \
		--prefix /usr \
		--no-pulse \
		--no-X11 \
		--no-gtk+-2.0 \
  		--cross-compile \
		--without-comp-doc \
		--without-comp-comp-bin \
  		--default-driver alsa \
		--audio-group '(none)'
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

#PACKAGES =+ "roard roar-utils"

#FILES_roard = "${bindir}/roard"
#FILES_roar-utils = "${bindir}/roar*"

