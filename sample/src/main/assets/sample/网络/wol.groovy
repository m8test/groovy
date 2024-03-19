package sample.网络

/**
 * 发送 wake on lan 数据包, 用户唤醒局域网中的指定设备
 * @param macAddress 需要唤醒的设备的mac地址, 格式为 AA:BB:CC:DD:EE:FF
 * @param broadcastAddressArray 广播ip地址, 格式为 [int, int, int, int] 默认为 [255, 255, 255, 255]
 * @param broadcastPort 广播端口, 默认为 9
 * @return
 */
static def wol(String macAddress, int[] broadcastAddressArray = [255, 255, 255, 255], int broadcastPort = 9) {
    def magicPacket = [(1..6).collect { 0xff },
                       (1..16).collect { macAddress.split(":").collect { Integer.parseInt(it, 16) } }].flatten()
    def broadcastAddress = InetAddress.getByAddress(broadcastAddressArray as byte[])
    def packet = new DatagramPacket(magicPacket as byte[], magicPacket.size, broadcastAddress, broadcastPort)
    def socket = new DatagramSocket()
    socket.send(packet)
}
// 填写正确的mac地址
wol("AA:BB:CC:DD:EE:FF")