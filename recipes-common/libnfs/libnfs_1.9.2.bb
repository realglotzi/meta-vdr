DESCRIPTION = "LIBNFS is a client library for accessing NFS shares over a network."
HOMEPAGE = "https://github.com/sahlberg/libnfs"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=a8375400e512ca525d061f32fb28b83a"

PR = "r0"

SRC_URI = "https://github.com/sahlberg/libnfs/archive/libnfs-${PV}.tar.gz"

SRC_URI[md5sum] = "8994aee31cccc1b83ef15d5355fe3d16"
SRC_URI[sha256sum] = "77d9d543eb1ae3e36497e5a3d4f37c8dd3d66def8d11817d4ed84368bbbb225b"

S = "${WORKDIR}/${PN}-${PN}-${PV}"

inherit autotools
