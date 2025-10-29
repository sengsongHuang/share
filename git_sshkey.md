
# Mac 上產生 SSH Key 並加到 GitHub 的完整指南

- [Mac 上產生 SSH Key 並加到 GitHub 的完整指南](#mac-上產生-ssh-key-並加到-github-的完整指南)
  - [參考資料](#參考資料)
  - [1. 檢查是否已有 SSH Key](#1-檢查是否已有-ssh-key)
  - [2. 產生新的 SSH Key](#2-產生新的-ssh-key)
    - [如果你的系統不支援 Ed25519](#如果你的系統不支援-ed25519)
    - [產生過程中的提示](#產生過程中的提示)
  - [3. 將 SSH Key 加到 SSH Agent](#3-將-ssh-key-加到-ssh-agent)
    - [啟動 SSH Agent](#啟動-ssh-agent)
    - [修改 SSH 配置檔案（macOS Sierra 10.12.2 或更新版本）](#修改-ssh-配置檔案macos-sierra-10122-或更新版本)
    - [將 SSH Key 加到 SSH Agent](#將-ssh-key-加到-ssh-agent)
  - [4. 複製 SSH Public Key](#4-複製-ssh-public-key)
  - [5. 將 SSH Key 加到 GitHub](#5-將-ssh-key-加到-github)
    - [步驟一：登入 GitHub](#步驟一登入-github)
    - [步驟二：進入 SSH Key 設定](#步驟二進入-ssh-key-設定)
    - [步驟三：新增 SSH Key](#步驟三新增-ssh-key)
  - [6. 測試 SSH 連線](#6-測試-ssh-連線)
  - [7. 將現有的 HTTPS Repository 轉換為 SSH](#7-將現有的-https-repository-轉換為-ssh)
    - [查看現在的遠端 URL](#查看現在的遠端-url)
    - [更改為 SSH URL](#更改為-ssh-url)
    - [驗證更改](#驗證更改)
  - [8. 使用 SSH Clone 新的 Repository](#8-使用-ssh-clone-新的-repository)
  - [9. 常見問題解決](#9-常見問題解決)
    - [問題：Permission denied (publickey)](#問題permission-denied-publickey)
    - [問題：Bad owner or permissions on ~/.ssh/config](#問題bad-owner-or-permissions-on-sshconfig)
    - [問題：ssh-add 要求密碼但沒有反應](#問題ssh-add-要求密碼但沒有反應)
  - [10. SSH Key 的安全建議](#10-ssh-key-的安全建議)



這個指南將教你如何在 Mac 上產生 SSH key，並將其加到 GitHub 帳號中，讓你可以安全地推送和拉取代碼而不需要每次都輸入密碼。

## 參考資料
- [git 基本操作說明](git_basic.md)
- [用 git 分享程式並協作修改說明](git_howto.md)
  
## 1. 檢查是否已有 SSH Key

首先檢查你的 Mac 是否已經有 SSH key：

```bash
ls -al ~/.ssh
```

如果你看到類似 `id_rsa.pub`、`id_ed25519.pub` 的檔案，表示你已經有 SSH key 了。

## 2. 產生新的 SSH Key

如果沒有 SSH key，或者想要產生新的，使用以下命令：

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

**說明**：
- `-t ed25519`：使用 Ed25519 演算法（推薦，更安全且更快）
- `-C "your_email@example.com"`：替換為你的 GitHub 電子郵件地址

### 如果你的系統不支援 Ed25519

如果遇到錯誤，可以使用 RSA 演算法：

```bash
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

### 產生過程中的提示

1. **儲存位置**：按 Enter 使用預設位置 (`/Users/你的用戶名/.ssh/id_ed25519`)
2. **設定密碼**：可以設定密碼保護你的 key，或按 Enter 跳過（不推薦跳過）

```
Generating public/private ed25519 key pair.
Enter file in which to save the key (/Users/username/.ssh/id_ed25519): [按 Enter]
Enter passphrase (empty for no passphrase): [輸入密碼或按 Enter]
Enter same passphrase again: [再次輸入密碼或按 Enter]
```

## 3. 將 SSH Key 加到 SSH Agent

### 啟動 SSH Agent

```bash
eval "$(ssh-agent -s)"
```

### 修改 SSH 配置檔案（macOS Sierra 10.12.2 或更新版本）

建立或編輯 `~/.ssh/config` 檔案：

```bash
touch ~/.ssh/config
open ~/.ssh/config
```

在檔案中加入以下內容：

```
Host *
  AddKeysToAgent yes
  UseKeychain yes
  IdentityFile ~/.ssh/id_ed25519
```

**注意**：如果你使用的是 RSA key，將 `id_ed25519` 替換為 `id_rsa`。

### 將 SSH Key 加到 SSH Agent

```bash
ssh-add --apple-use-keychain ~/.ssh/id_ed25519
```

如果是 RSA key：
```bash
ssh-add --apple-use-keychain ~/.ssh/id_rsa
```

## 4. 複製 SSH Public Key

將你的 SSH public key 複製到剪貼簿：

```bash
pbcopy < ~/.ssh/id_ed25519.pub
```

如果是 RSA key：
```bash
pbcopy < ~/.ssh/id_rsa.pub
```

或者你也可以直接查看並手動複製：

```bash
cat ~/.ssh/id_ed25519.pub
```

## 5. 將 SSH Key 加到 GitHub

### 步驟一：登入 GitHub
1. 前往 [GitHub.com](https://github.com) 並登入你的帳號

### 步驟二：進入 SSH Key 設定
1. 點擊右上角的頭像
2. 選擇 **Settings**
3. 在左側邊欄點擊 **SSH and GPG keys**

### 步驟三：新增 SSH Key
1. 點擊 **New SSH key** 或 **Add SSH key**
2. 在 **Title** 欄位輸入描述性的標題，例如 "MacBook Pro"
3. 在 **Key** 欄位貼上你剛才複製的 SSH public key
4. 點擊 **Add SSH key**
5. 如果提示，輸入你的 GitHub 密碼確認

## 6. 測試 SSH 連線

測試你的 SSH 連線是否設定成功：

```bash
ssh -T git@github.com
```

如果設定成功，你會看到類似以下的訊息：

```
Hi username! You've successfully authenticated, but GitHub does not provide shell access.
```

## 7. 將現有的 HTTPS Repository 轉換為 SSH

如果你之前使用 HTTPS clone 的 repository，現在想要使用 SSH，可以更改遠端 URL：

### 查看現在的遠端 URL
```bash
git remote -v
```

### 更改為 SSH URL
```bash
git remote set-url origin git@github.com:username/repository-name.git
```

例如：
```bash
git remote set-url origin git@github.com:sengsongHuang/share.git
```

### 驗證更改
```bash
git remote -v
```

## 8. 使用 SSH Clone 新的 Repository

從現在開始，當你 clone repository 時，使用 SSH URL：

```bash
git clone git@github.com:username/repository-name.git
```

而不是 HTTPS URL：
```bash
git clone https://github.com/username/repository-name.git
```

## 9. 常見問題解決

### 問題：Permission denied (publickey)
**解決方法**：
1. 確認 SSH key 已經加到 GitHub
2. 檢查 SSH agent 是否運行：`ssh-add -l`
3. 重新加入 key：`ssh-add --apple-use-keychain ~/.ssh/id_ed25519`

### 問題：Bad owner or permissions on ~/.ssh/config
**解決方法**：
```bash
chmod 600 ~/.ssh/config
chmod 700 ~/.ssh
```

### 問題：ssh-add 要求密碼但沒有反應
**解決方法**：
確認 SSH agent 正在運行：
```bash
eval "$(ssh-agent -s)"
```

## 10. SSH Key 的安全建議

1. **使用密碼保護**：為你的 SSH key 設定強密碼
2. **定期更新**：建議每 1-2 年更新 SSH key
3. **不要分享私鑰**：永遠不要分享 `id_ed25519` 檔案（私鑰）
4. **備份**：將你的 SSH key 安全地備份

---

完成以上步驟後，你就可以使用 SSH 來安全地與 GitHub 互動，不再需要每次都輸入用戶名和密碼！