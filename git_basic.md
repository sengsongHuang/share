# Git 基本操作指南


- [Git 基本操作指南](#git-基本操作指南)
  - [1. 克隆專案](#1-克隆專案)
  - [2. VS Code 中的 Git 狀態指示](#2-vs-code-中的-git-狀態指示)
    - [檔案狀態顏色](#檔案狀態顏色)
    - [VS Code 側邊欄的 Source Control](#vs-code-側邊欄的-source-control)
  - [3. 基本 Git 工作流程](#3-基本-git-工作流程)
    - [步驟一：查看狀態](#步驟一查看狀態)
    - [步驟二：加入變更到暫存區](#步驟二加入變更到暫存區)
    - [步驟三：提交變更](#步驟三提交變更)
    - [步驟四：同步遠端變更](#步驟四同步遠端變更)
    - [步驟五：推送變更到遠端](#步驟五推送變更到遠端)
  - [4. 最常用的日常操作流程](#4-最常用的日常操作流程)
  - [5. 完整的工作流程範例](#5-完整的工作流程範例)
  - [6. VS Code 中的 Git 操作](#6-vs-code-中的-git-操作)
    - [使用 VS Code 的圖形化介面](#使用-vs-code-的圖形化介面)
    - [快速鍵](#快速鍵)
  - [7. 常用檢查命令](#7-常用檢查命令)
  - [8. 注意事項](#8-注意事項)

這是一個 Git 基本操作的快速指南，適合剛開始使用 Git 和 VS Code 的開發者。

## 1. 克隆專案

當你想要下載一個 Git 專案到本地時：

```bash
git clone <repository-url>
cd <project-folder>
```

例如：
```bash
git clone https://github.com/username/project-name.git
cd project-name
```

## 2. VS Code 中的 Git 狀態指示

在 VS Code 中，你可以透過檔案旁邊的顏色和符號來了解檔案的 Git 狀態：

### 檔案狀態顏色
- **綠色 (G)**：新增的檔案 (新建立且未被追蹤的檔案)
- **黃色 (M)**：已修改的檔案 (Modified)
- **紅色 (D)**：已刪除的檔案 (Deleted)
- **藍色 (R)**：重新命名的檔案 (Renamed)
- **灰色**：被忽略的檔案 (.gitignore 中列出的檔案)

### VS Code 側邊欄的 Source Control
- 點擊左側的分支圖示可以看到所有變更
- 檔案旁邊會顯示 `M`、`A`、`D` 等狀態標記
- 可以直接在這裡進行 commit 操作

## 3. 基本 Git 工作流程

### 步驟一：查看狀態
```bash
git status
```
這會顯示哪些檔案被修改、新增或刪除。

### 步驟二：加入變更到暫存區
```bash
# 加入所有變更
git add .

# 或加入特定檔案
git add filename.txt
```

### 步驟三：提交變更
```bash
# 提交已暫存的變更
git commit -m "你的提交訊息"

# 或者同時加入並提交 (適用於已追蹤的檔案)
git commit -am "修改現有檔案的提交訊息"
```

**注意**：`git commit -am` 只對已經被 Git 追蹤的檔案有效，新檔案仍需要先用 `git add` 加入。

### 步驟四：同步遠端變更
```bash
# 獲取遠端最新狀態 (不會合併)
git fetch

# 拉取遠端變更並合併到本地
git pull
```

### 步驟五：推送變更到遠端
```bash
git push
```

## 4. 最常用的日常操作流程

這是最常用的 Git 工作流程，適合日常開發：

```bash
# 1. 打開 VS Code 並開啟專案目錄, 並按下 Ctrl + ` 開啟終端機
[file] -> [Open Folder] -> [選擇專案目錄]

# 2. 用 VS Code 修改檔案

# 3. 修改檔案後，直接提交 (適用於已存在的檔案)
git commit -am "修復登入 bug"

# 4. 從 GitHub 拉取最新變更 (如果有的話)
git pull

# 5. 推送到 GitHub
git push
```

**說明**：
- `code .` 在當前目錄開啟 VS Code
- `git commit -am` 會自動將已修改的檔案加入並提交 (但不包含新檔案)
- `git pull` 確保你有最新的遠端變更
- `git push` 將你的變更推送到 GitHub

**注意**：如果有新增檔案，需要先使用 `git add .` 將新檔案加入追蹤。

## 5. 完整的工作流程範例

假設你克隆了一個專案並想要修改一些檔案：

```bash
# 1. 克隆專案
git clone https://github.com/username/project.git
cd project

# 2. 用 VS Code 開啟專案
code .

# 3. 修改檔案後，查看狀態
git status

# 4. 加入變更
git add .

# 5. 提交變更
git commit -m "修復了登入功能的 bug"

# 6. 獲取遠端最新狀態
git fetch

# 7. 拉取可能的遠端變更
git pull

# 8. 推送你的變更
git push
```

## 6. VS Code 中的 Git 操作

### 使用 VS Code 的圖形化介面
1. **查看變更**：點擊左側的源代碼控制圖示 (分支符號)
2. **暫存變更**：點擊檔案旁的 `+` 號
3. **提交變更**：在訊息框輸入提交訊息，按 `Ctrl+Enter` (Mac: `Cmd+Enter`)
4. **推送/拉取**：點擊狀態欄的同步按鈕，或使用命令面板 (`Ctrl+Shift+P`)

### 快速鍵
- `Ctrl+Shift+G` (Mac: `Cmd+Shift+G`)：開啟源代碼控制面板
- `Ctrl+Shift+P` (Mac: `Cmd+Shift+P`)：開啟命令面板，可以搜尋 Git 命令

## 7. 常用檢查命令

```bash
# 查看提交歷史
git log --oneline

# 查看遠端分支狀態
git remote -v

# 查看當前分支
git branch

# 查看檔案的具體變更
git diff filename.txt
```

## 8. 注意事項

1. **提交訊息要清楚**：描述你做了什麼變更
2. **經常同步**：定期使用 `git pull` 保持與遠端同步
3. **小量提交**：盡量將相關的變更分組提交，不要一次提交太多不相關的修改
4. **檢查狀態**：提交前使用 `git status` 確認你要提交的內容

---

這些是 Git 的基本操作，足以應付大部分的日常開發工作。當你熟悉這些操作後，可以進一步學習分支 (branch)、合併 (merge)、儲藏 (stash) 等進階功能。