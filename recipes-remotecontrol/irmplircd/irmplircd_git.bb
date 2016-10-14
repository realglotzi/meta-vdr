DESCRIPTION = "IRMP lirc client"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r4"

SRCREV  = "813b03609f24054792deed1274f07d4da4d9b7bd"
SRC_URI = "git://github.com/realglotzi/irmplircd.git \
           file://irmplircd.service \
           file://56-irmp.rules \
          "

S = "${WORKDIR}/git"

inherit systemd

## Install in ${D}
export DEST = "${D}/usr/bin"

EXTRA_OEMAKE = "CFLAGS=-Ic_hashmap"	
TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {

	install -d ${D}${bindir}/
	install -m 0755 ${S}/irmplircd ${D}${bindir}/
	install -m 0755 ${S}/irmpexec  ${D}${bindir}/ 
	
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/irmplircd.service ${D}${systemd_unitdir}/system

	install -d ${D}${sysconfdir}/udev/rules.d	
	install -m 0755 ${WORKDIR}/56-irmp.rules ${D}${sysconfdir}/udev/rules.d
	
}

SYSTEMD_SERVICE_${PN} = "irmplircd.service"
RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"

FILES_${PN} = "${bindir}/irmplircd ${bindir}/irmpexec ${systemd_unitdir}/system/irmplircd.service ${sysconfdir}/udev/rules.d/56-irmp.rules"
