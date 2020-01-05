package bonch.dev.katemobile

interface ClickListenerSections {
    fun onHeaderRootViewClicked(sectionTitle: String, section: VideoAdapter)

    fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int)
}