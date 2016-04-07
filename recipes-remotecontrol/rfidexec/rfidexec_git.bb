DESCRIPTION = "RFID client"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r2"

SRCREV  = "e64e2a8f7ea1c3931d803b680ba99a3520b63885"
SRC_URI = "git://github.com/realglotzi/rfidexec.git \
          "

S = "${WORKDIR}/git"

## Install in ${D}
export DEST = "${D}/usr/bin"

#EXTRA_OEMAKE = "CFLAGS=-Ic_hashmap"	

do_install() {

	install -d ${D}${bindir}/
	install -m 0755 ${S}/rfidexec  ${D}${bindir}/ 
	
	install -d ${D}${systemd_unitdir}/system
	install -m 0755 ${S}/scripts/rfidexec.service ${D}${systemd_unitdir}/system

	install -d ${D}${sysconfdir}/udev/rules.d	
	install -m 0755 ${S}/scripts/99-rfid.rules ${D}${sysconfdir}/udev/rules.d
	
}

FILES_${PN} = "${bindir}/rfidexec ${systemd_unitdir}/system/rfidexec.service ${sysconfdir}/udev/rules.d/99-rfid.rules"
