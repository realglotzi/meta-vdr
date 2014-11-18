DESCRIPTION = "IRMP lirc client"
SECTION = "multimedia"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

PR = "r1"

SRCREV  = "1b72de7d7225c5b3b8a41ae5ec5ab0abb58c210a"
SRC_URI = "git://github.com/realglotzi/irmplircd.git \
	   file://init \
           file://56-irmp.rules \
          "


SRC_URI[md5sum] = "af6084c6ff387298543ffb155c53bb79"
SRC_URI[sha256sum] = "ba0f883e13df8a8b9ee8f75fad2185e7f33bb6dbaab3ff96f7ef58195289193a"

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
