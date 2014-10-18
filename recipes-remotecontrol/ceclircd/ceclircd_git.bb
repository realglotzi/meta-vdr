DESCRIPTION = "CEC lirc client for the Raspberry Pi"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"
DEPENDS = " libcec-rpi log4cplus"

PR = "r0"

SRCREV = "5c949d106864c3bc01e7d38ef3a32cef56c361d7"
SRC_URI = "git://github.com/realglotzi/ceclircd.git \
           file://init \
          "

SRC_URI[md5sum] = "af6084c6ff387298543ffb155c53bb79"
SRC_URI[sha256sum] = "ba0f883e13df8a8b9ee8f75fad2185e7f33bb6dbaab3ff96f7ef58195289193a"

S = "${WORKDIR}/git/src"

inherit update-rc.d

INITSCRIPT_NAME = "ceclircd"
INITSCRIPT_PARAMS = "defaults 19" 

COMPATIBLE_MACHINE = "raspberrypi"

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
