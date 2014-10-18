DESCRIPTION = "VOMP client for the Raspberry Pi"
HOMEPAGE = "http://www.loggytronic.com/vomp.php"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = " virtual/libgl virtual/libgles2 virtual/egl libav freetype libcec-rpi imagemagick"

PR = "r2"

SRCREV = "master"
SRC_URI = "git://git.vomp.tv/vompclient-raspi.git;protocol=http \
           file://init \
           file://make-oe.patch \
           file://0001-Fixed-sig.patch \
          "

S = "${WORKDIR}/git"

inherit update-rc.d

INITSCRIPT_NAME = "vompclient"
INITSCRIPT_PARAMS = "defaults 20" 

COMPATIBLE_MACHINE = "raspberrypi"

export LIBPATHS = "-L${STAGING_DIR_HOST}/lib \
                   -L${STAGING_DIR_HOST}/usr/lib \
                   -L${STAGING_DIR_HOST}/usr/lib/vc \
                  "

export INCLUDES = "-I${STAGING_DIR_HOST}/usr/include \
                   -I${STAGING_DIR_HOST}/usr/include/interface/vcos \
                   -I${STAGING_DIR_HOST}/usr/include/interface/vcos/generic \
                   -I${STAGING_DIR_HOST}/usr/include/interface/vcos/pthreads \
				   -I${STAGING_DIR_HOST}/usr/include/vc \
                   -I${STAGING_DIR_HOST}/usr/include/freetype2 \
                   -I${STAGING_DIR_HOST}/usr/include/ImageMagick \
                  "
## Install in ${D}
export DEST = "${D}/usr/bin"
	
do_compile() {
	oe_runmake -f Makefile.oe
}

do_install() {

	install -d ${D}${bindir}/
	install -m 0755 ${S}/vompclient ${D}${bindir}/
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/vompclient
	
#	install -d ${D}${sysconfdir}/default
#	install -m 0755 ${WORKDIR}/default ${D}${sysconfdir}/default/vompclient
	
}

FILES_${PN} = "${bindir}/vompclient  ${sysconfdir}/init.d/vompclient"
