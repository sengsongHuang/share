# GitHub 分享程式完整教學
- [GitHub 分享程式完整教學](#github-分享程式完整教學)
  - [前言](#前言)
  - [準備工作](#準備工作)
  - [詳細步驟](#詳細步驟)
    - [步驟 1：在 GitHub 建立新的 Repository（儲存庫）](#步驟-1在-github-建立新的-repository儲存庫)
    - [步驟 2：複製 Repository URL](#步驟-2複製-repository-url)
    - [步驟 3：在本地電腦準備工作目錄](#步驟-3在本地電腦準備工作目錄)
    - [步驟 4：Clone 空的 Repository 到本地](#步驟-4clone-空的-repository-到本地)
    - [步驟 5：複製你的程式碼到 Repository 目錄](#步驟-5複製你的程式碼到-repository-目錄)
    - [步驟 6：設定 Git 基本資訊（第一次使用需要）](#步驟-6設定-git-基本資訊第一次使用需要)
    - [步驟 7：將檔案加入 Git 追蹤](#步驟-7將檔案加入-git-追蹤)
    - [步驟 8：提交變更](#步驟-8提交變更)
    - [步驟 9：推送到 GitHub](#步驟-9推送到-github)
  - [完成！](#完成)
  - [後續修改程式碼的流程](#後續修改程式碼的流程)
  - [常見問題](#常見問題)
    - [Q: 為什麼要用 Git？](#q-為什麼要用-git)
    - [Q: Public 和 Private Repository 的差別？](#q-public-和-private-repository-的差別)
    - [Q: 如何讓朋友參與修改程式碼？](#q-如何讓朋友參與修改程式碼)
    - [Q: 程式碼太大怎麼辦？](#q-程式碼太大怎麼辦)
  - [實用指令備忘錄](#實用指令備忘錄)

## 前言
這份教學將教你如何把自己的程式碼上傳到 GitHub 分享給朋友。即使你從未使用過 Git 或 GitHub，也能按照步驟順利完成。

## 準備工作
1. 註冊 GitHub 帳號：前往 [github.com](https://github.com) 註冊
2. 安裝 Git：
   - macOS：在終端機執行 `brew install git` 或 `git --version`（通常已內建）
   - Windows：下載 [Git for Windows](https://git-scm.com/download/win)
   - Linux：執行 `sudo apt install git` 或 `sudo yum install git`

## 詳細步驟

### 步驟 1：在 GitHub 建立新的 Repository（儲存庫）
1. 登入 GitHub
2. 點擊右上角的 "+" 號，選擇 "New repository"
3. 填寫 Repository 名稱（例如：`my-java-project`）
4. 選擇 "Public"（公開）或 "Private"（私人）
5. **重要：不要勾選任何初始化選項**（不要勾選 README、.gitignore、license）
6. 點擊 "Create repository"

### 步驟 2：複製 Repository URL
1. 在新建的 Repository 頁面，點擊綠色的 "Code" 按鈕
2. 選擇 "HTTPS" 分頁
3. 複製顯示的 URL（格式類似：`https://github.com/你的帳號/my-java-project.git`）

### 步驟 3：在本地電腦準備工作目錄
```bash
# 建立一個專門放 GitHub 專案的目錄
mkdir ~/github-projects
cd ~/github-projects
```

### 步驟 4：Clone 空的 Repository 到本地
```bash
# 替換下面的 URL 為你在步驟 2 複製的 URL
git clone https://github.com/你的帳號/my-java-project.git
cd my-java-project
```

### 步驟 5：複製你的程式碼到 Repository 目錄
```bash
# 假設你的程式碼在 ~/java/test1 目錄
# 複製所有檔案到目前的 git repository 目錄
cp ~/java/test1/* .

# 或者如果你的程式在其他地方，調整路徑
# cp /path/to/your/project/* .
```

### 步驟 6：設定 Git 基本資訊（第一次使用需要）
```bash
# 設定你的姓名和 email（用於記錄提交者資訊）
git config --global user.name "你的名字"
git config --global user.email "你的email@example.com"
```

### 步驟 7：將檔案加入 Git 追蹤
```bash
# 查看目前狀態
git status

# 將所有檔案加入追蹤
git add .

# 再次查看狀態確認
git status
```

### 步驟 8：提交變更
```bash
# 提交變更並加上說明訊息
git commit -m "Initial commit: Add my Java project"
```

### 步驟 9：推送到 GitHub
```bash
# 將本地的變更推送到 GitHub
git push origin main
```

**注意：** 如果出現錯誤說沒有 `main` 分支，可能是 `master` 分支，試試：
```bash
git push origin master
```

## 完成！

現在你的程式碼已經上傳到 GitHub 了！你可以：
1. 在瀏覽器開啟你的 Repository 頁面查看
2. 分享 Repository URL 給朋友
3. 朋友可以點擊 "Code" → "Download ZIP" 下載你的程式碼

## 後續修改程式碼的流程

當你修改程式碼後，要更新到 GitHub：

```bash
# 1. 進入你的專案目錄
cd ~/github-projects/my-java-project

# 2. 複製新的程式碼（覆蓋舊的）
cp ~/java/test1/* .

# 3. 查看變更
git status

# 4. 加入變更
git add .

# 5. 提交變更
git commit -m "Update: 描述你做了什麼修改"

# 6. 推送到 GitHub
git push
```

## 常見問題

### Q: 為什麼要用 Git？
A: Git 可以追蹤程式碼的版本變化，GitHub 則提供免費的雲端儲存和分享平台。

### Q: Public 和 Private Repository 的差別？
A: Public 代表任何人都能看到你的程式碼，Private 只有你和你授權的人能看到。

### Q: 如何讓朋友參與修改程式碼？
A: 在 Repository 頁面點擊 "Settings" → "Manage access" → "Invite a collaborator"

### Q: 程式碼太大怎麼辦？
A: GitHub 免費帳號有容量限制，避免上傳太大的檔案（如編譯後的執行檔）。

## 實用指令備忘錄

```bash
# 查看目前狀態
git status

# 查看提交歷史
git log --oneline

# 查看遠端 Repository 資訊
git remote -v

# 從 GitHub 拉取最新版本
git pull

# 查看檔案差異
git diff
```

---

**小提醒：** 第一次使用可能會遇到一些權限問題，這是正常的！按照錯誤訊息的指示通常就能解決。不要害怕出錯，多練習幾次就熟悉了！
