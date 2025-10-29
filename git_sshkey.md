
# Mac 上產生 SSH Key 並加到 GitHub 的簡易指南

- [Mac 上產生 SSH Key 並加到 GitHub 的簡易指南](#mac-上產生-ssh-key-並加到-github-的簡易指南)
  - [參考資料](#參考資料)
  - [1. 產生 SSH Key](#1-產生-ssh-key)
  - [2. 複製 SSH Public Key](#2-複製-ssh-public-key)
  - [3. 將 SSH Key 加到 GitHub](#3-將-ssh-key-加到-github)
    - [步驟一：登入 GitHub](#步驟一登入-github)
    - [步驟二：進入 SSH Key 設定](#步驟二進入-ssh-key-設定)
    - [步驟三：新增 SSH Key](#步驟三新增-ssh-key)
  - [4. 測試 SSH 連線](#4-測試-ssh-連線)
  - [5. 使用 SSH Clone Repository](#5-使用-ssh-clone-repository)
  - [6. 將現有的 Repository 改用 SSH](#6-將現有的-repository-改用-ssh)

最簡單的方式讓你可以用 SSH 連接 GitHub，不用每次都輸入密碼。

## 參考資料
- [README 教學指南集合](README.md)
- [git 基本操作說明](git_basic.md)
- [用 git 分享程式並協作修改說明](git_howto.md)

## 1. 產生 SSH Key

開啟終端機，輸入以下命令：

```bash
ssh-keygen -t rsa
```

**過程中的提示**：
1. **儲存位置**：直接按 Enter（使用預設位置）
2. **設定密碼**：直接按 Enter（不設密碼，方便使用）
3. **再次確認密碼**：直接按 Enter

```
Generating public/private rsa key pair.
Enter file in which to save the key (/Users/username/.ssh/id_rsa): [按 Enter]
Enter passphrase (empty for no passphrase): [按 Enter]
Enter same passphrase again: [按 Enter]
```

## 2. 複製 SSH Public Key
將你的 SSH public key 複製到剪貼簿：

```bash
pbcopy < ~/.ssh/id_rsa.pub
```

或者你也可以直接查看並手動複製：

```bash
cat ~/.ssh/id_rsa.pub
```

## 3. 將 SSH Key 加到 GitHub

### 步驟一：登入 GitHub
1. 前往 [GitHub.com](https://github.com) 並登入你的帳號

### 步驟二：進入 SSH Key 設定
1. 點擊右上角的頭像
2. 選擇 **Settings**
3. 在左側邊欄點擊 **SSH and GPG keys**

### 步驟三：新增 SSH Key
1. 點擊 **New SSH key** 或 **Add SSH key**
2. 在 **Title** 欄位輸入描述性的標題，例如 "我的 MacBook"
3. 在 **Key** 欄位貼上你剛才複製的 SSH public key
4. 點擊 **Add SSH key**
5. 如果提示，輸入你的 GitHub 密碼確認

## 4. 測試 SSH 連線

測試你的 SSH 連線是否設定成功：

```bash
ssh -T git@github.com
```

如果設定成功，你會看到類似以下的訊息：

```
Hi username! You've successfully authenticated, but GitHub does not provide shell access.
```

## 5. 使用 SSH Clone Repository

從現在開始，當你 clone repository 時，使用 SSH URL：

```bash
git clone git@github.com:username/repository-name.git
```

而不是 HTTPS URL：
```bash
git clone https://github.com/username/repository-name.git
```

## 6. 將現有的 Repository 改用 SSH

如果你之前用 HTTPS clone 的 repository，想要改用 SSH：

```bash
# 查看現在的 URL
git remote -v

# 改為 SSH URL
git remote set-url origin git@github.com:username/repository-name.git

# 確認更改
git remote -v
```

---

完成以上步驟後，你就可以用 SSH 來與 GitHub 互動，不再需要每次都輸入用戶名和密碼！