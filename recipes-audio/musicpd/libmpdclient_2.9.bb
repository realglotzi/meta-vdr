DESCRIPTION = "Music Player Daemon client library"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"
HOMEPAGE ="http://sourceforge.net/projects/musicpd"
DEPENDS = "glib-2.0"

SRC_URI = "http://www.musicpd.org/download/${PN}/2/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "310ccdb82c809ee1191f2f107e92bf22"
SRC_URI[sha256sum] = "82f760c364f91a35f4a59543d98369f88f3ec62c59f6e873bc7c556a474e4b33"

inherit autotools

FILES_${PN}-dbg += " /usr/share/vala/* \
					 /usr/share/vala/vapi/* \
					 /usr/share/vala/vapi/libmpdclient.vapi"