DESCRIPTION = "CEC lirc client for the Raspberry Pi"
SECTION = "multimedia"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "(raspberrypi|raspberrypi2)"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r2"

SRCREV = "c4992972c3a23b46bb1a0ba517e3c23ba3a2ec56"
SRC_URI = "git://github.com/realglotzi/ceclircd.git \
           file://init \
          "

S = "${WORKDIR}/git/src"

DEPENDS = " libcec-rpi log4cplus"

inherit update-rc.d

INITSCRIPT_NAME = "ceclircd"
INITSCRIPT_PARAMS = "defaults 19" 

## Install in ${D}
export DEST = "${D}/usr/bin"

EXTRA_OEMAKE = "CXXFLAGS=-std=c++11"	

do_install() {

	install -d ${D}${bindir}/
	install -m 0755 ${S}/ceclircd ${D}${bindir}/
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ceclircd
	
}

FILES_${PN} = "${bindir}/ceclircd  ${sysconfdir}/init.d/ceclircd"
