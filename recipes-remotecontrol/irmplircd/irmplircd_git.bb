DESCRIPTION = "IRMP lirc client"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r2"

SRCREV  = "813b03609f24054792deed1274f07d4da4d9b7bd"
SRC_URI = "git://github.com/realglotzi/irmplircd.git \
           file://init \
           file://56-irmp.rules \
          "

S = "${WORKDIR}/git"

inherit update-rc.d

INITSCRIPT_NAME = "irmplircd"
INITSCRIPT_PARAMS = "defaults 20" 

## Install in ${D}
export DEST = "${D}/usr/bin"

EXTRA_OEMAKE = "CFLAGS=-Ic_hashmap"	

do_install() {

	install -d ${D}${bindir}/
	install -m 0755 ${S}/irmplircd ${D}${bindir}/
	install -m 0755 ${S}/irmpexec  ${D}${bindir}/ 
	
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/irmplircd

	install -d ${D}${sysconfdir}/udev/rules.d	
	install -m 0755 ${WORKDIR}/56-irmp.rules ${D}${sysconfdir}/udev/rules.d
	
}

FILES_${PN} = "${bindir}/irmplircd ${bindir}/irmpexec ${sysconfdir}/init.d/irmplircd ${sysconfdir}/udev/rules.d/56-irmp.rules"
