SUMMARY = "runvdr-extreme start script"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=e673a95e6911049cc1cadf00eac1f759"

SRCREV = "f029de7198f92e2583d1065bc2a8b518aa18daf4"
SRC_URI = "git://projects.vdr-developer.org/runvdr-extreme.git \
           file://runvdr.service \
           file://runvdr-extreme-echo.patch \
          "

PR="r3"

S = "${WORKDIR}/git"

inherit systemd

DEPENDS = " \
	procps \
	console-tools \
	util-linux \
"

RDEPENDS_${PN} += "bash"

do_install() {
	install -d ${D}${bindir}/                                                                                                                                                                                  
	install -m 0755 ${S}/runvdr ${D}${bindir}/runvdr-extreme

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/runvdr.service ${D}${systemd_unitdir}/system
}																																													
SYSTEMD_SERVICE_${PN} = "runvdr.service"
RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
 
FILES_${PN} = " ${bindir}/runvdr-extreme ${systemd_unitdir}/system/runvdr.service"

