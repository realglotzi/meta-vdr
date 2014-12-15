DESCRIPTION = "LIBNFS is a client library for accessing NFS shares over a network."
HOMEPAGE = "https://github.com/sahlberg/libnfs"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=0019ace2726c6f181791a9ac04c7ac6a"

PR = "r1"

SRC_URI = "https://github.com/sahlberg/libnfs/archive/libnfs-${PV}.tar.gz"

SRC_URI[md5sum] = "ff91a3eb51ec37b0105b5687ea01326f"
SRC_URI[sha256sum] = "75f49d967e9032e0ee4757f970f87c274c3503c968caba2be8a37df63d965f32"

S = "${WORKDIR}/${PN}-${PN}-${PV}"

inherit autotools
