DESCRIPTION = "RFID client"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r1"

SRCREV  = "d913bb0bcc920ee7efdd36be2d88b1502f1d9c7d"
SRC_URI = "git://github.com/realglotzi/rfidexec.git \
           file://init \
           file://99-rfid.rules \
          "

S = "${WORKDIR}/git"

inherit update-rc.d

INITSCRIPT_NAME = "rfidexec"
INITSCRIPT_PARAMS = "defaults 20" 

## Install in ${D}
export DEST = "${D}/usr/bin"

#EXTRA_OEMAKE = "CFLAGS=-Ic_hashmap"	

do_install() {

	install -d ${D}${bindir}/
	install -m 0755 ${S}/rfidexec  ${D}${bindir}/ 
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/rfidexec

	install -d ${D}${sysconfdir}/udev/rules.d	
	install -m 0755 ${WORKDIR}/99-rfid.rules ${D}${sysconfdir}/udev/rules.d
	
}

FILES_${PN} = "${bindir}/rfidexec ${sysconfdir}/init.d/rfidexec ${sysconfdir}/udev/rules.d/99-rfid.rules"
