const fs = require('fs')
const path = require('path')

function copyFolder(sourcePath, destPath) {
  //recursive:true}创建多级目录
  fs.mkdirSync(destPath, { recursive: true })

  const files = fs.readdirSync(sourcePath, { withFileTypes: true })

  files.forEach(item => {
    const sourceItemPath = path.resolve(sourcePath, item.name)
    const destItemPath = path.resolve(destPath, item.name)

    if (item.isDirectory()) {
      copyFolder(sourceItemPath, destItemPath)
    } else {
      // 开始复制文件
      fs.copyFileSync(sourceItemPath, destItemPath)
      console.log(`${item.name}---拷贝成功`);
    }
  })
}

module.exports = {copyFolder: copyFolder}
